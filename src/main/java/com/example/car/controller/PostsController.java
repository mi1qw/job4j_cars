package com.example.car.controller;

import com.example.car.config.PostsConfig;
import com.example.car.dto.FilterDto;
import com.example.car.dto.PostDto;
import com.example.car.dto.PostMapper;
import com.example.car.service.CarService;
import com.example.car.service.dto.PaginationDto;
import com.example.car.util.CarModfctn;
import com.example.car.util.FilterForm;
import com.example.car.web.Pagination;
import com.example.car.util.PathForm;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
@Slf4j
public class PostsController {
    private final CarService carService;
    private final UserSession userSession;
    private final PostMapper postMapper;
    private final PathForm pathForm;
    private final PostsConfig postsConfig;

    @GetMapping("")
    String posts(final @ModelAttribute(name = "filter") FilterDto filterDto,
                 final @RequestParam(value = "page", defaultValue = "1",
                         required = false) int page,
                 final Model model) {
        FilterDto filterDto1;
        if (filterDto.getSort() == null) {
            filterDto1 = userSession.getFilterForm().getFilterDto();
        } else {
            filterDto1 = filterDto;
        }
        Pagination pagination = Pagination.of(page - 1, postsConfig.getPageSize());
        PaginationDto paginationDto = carService.filterForm(filterDto1, pagination);
        model.addAttribute("posts", paginationDto.cars());
        model.addAttribute("page", page);
        model.addAttribute("totalPages", paginationDto.pages());
        model.addAttribute("filter", filterDto1);
        return "posts";
    }

    @GetMapping("/{id}")
    String carPost(final @PathVariable("id") Long id,
                   final Model model) {
        CarModfctn carModfctn = carService.findCarPost(id);
        PostDto postDto = postMapper.carToPostDto(carModfctn.car(), carModfctn.modification());
        model.addAttribute("post", postDto);
        userSession.setNewCar(carModfctn.car());
        FilterDto filterDto = pathForm.carToFilterDto(carModfctn.car());
        userSession.setBreadcrumb(new FilterForm(filterDto));
        return "carPost";
    }

    @GetMapping("/slice/{nameFilter}")
    public String back(final @PathVariable("nameFilter") String nameFilter) {
        FilterForm filterForm = userSession.getBreadcrumb().sliceFilter(nameFilter);
        userSession.setFilterForm(filterForm);
        return "redirect:/posts";
    }
}
