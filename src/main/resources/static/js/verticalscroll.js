const slideGallery = document.querySelector('.slides');
const slides = slideGallery.querySelectorAll('div');
const scrollbarThumb = document.querySelector('.thumb');
const slideCount = slides.length;
const slideHeight = 624;
const marginTop = 16;
var thumbList;
var thumbPrevActive;
var run = true;
const scrollThumb = () => {
    const index = Math.floor(slideGallery.scrollTop / slideHeight);
    scrollbarThumb.style.height = `${((index + 1) / slideCount) * slideHeight}px`;


    if (run) {
        run = false;
        scrollThumbByImg();
        setTimeout(() => run = true, 250);
    }

};

const scrollThumbByImg = () => {
    let min = window.innerHeight;
    var innerHeightCenter = window.innerHeight / 2;
    let idx;
    for (let i = 0; i < [...slides].length; i++) {
        let pos = [...slides][i].getBoundingClientRect();
        let centerY = (pos.top + pos.bottom) / 2;
        // var scrollY = window.scrollY;
        let deltaPos;
        if (centerY > 0) {
            deltaPos = innerHeightCenter - centerY;
            let curr = Math.abs(deltaPos);
            if (curr < min) {
                min = curr;
            } else {
                idx = i - 1;
                break;
            }
        }
        // console.log(centerY, min, Math.abs(deltaPos));
    }
    idx = idx == undefined ? [...slides].length - 1 : idx;
    // console.log(idx);

    if (thumbList == null) {
        thumbList = document.querySelectorAll('.thumbnails img');
    }
    thumbPrevActive?.classList.remove('thumbnail-border')
    thumbPrevActive = thumbList.item(idx);
    thumbPrevActive.scrollIntoView(true);
    thumbPrevActive.classList.add('thumbnail-border');
}

const scrollToElement = el => {
    const index = parseInt(el.dataset.id, 10);
    // slideGallery.scrollTo(0, index * slideHeight + marginTop);

    [...slides][index].scrollIntoView(true);
};

document.querySelector('.thumbnails').innerHTML += [...slides]
    .map(
        (slide, i) => `<img src="${slide.querySelector('img').src}" data-id="${i}">`
    )
    .join('');

document.querySelectorAll('.thumbnails img').forEach(el => {
    el.addEventListener('click', () => scrollToElement(el));
});

// [...slides].forEach(n => {
//
// });

slideGallery.addEventListener('scroll', e => scrollThumb());

scrollThumb();


// Open the Modal
function openModal(idImg) {
    console.log("modal-dialog", document.getElementById('modal-dialog'))
    document.getElementById('modal-dialog').style.display = "block";

        [...slides][idImg].scrollIntoView(true);
}

// Close the Modal
function closeModal() {
    console.log("modal-dialog", document.getElementById('modal-dialog'))
    document.getElementById('modal-dialog').style.display = "none";
}