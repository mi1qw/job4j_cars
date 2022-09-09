// ************************ Start ***************** //
document.addEventListener('DOMContentLoaded', (event) => {
    if (isExistImages()) {
        addImgButton();
    }
    yearBuy();
});

// let inp = document.getElementById('fileElemEmpty');
let inp = document.getElementById('fileElem');
let emp = document.getElementById('emptyArea');

var gallery = document.getElementById('gallery');

emp.addEventListener('click', (e) => {
    console.log("inp.addEventListener('click'");
    inp.click();
});

// ************************ Drag and drop ***************** //
let dropArea = document.getElementById("drop-area")

// Prevent default drag behaviors
;['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false)
    document.body.addEventListener(eventName, preventDefaults, false)
})

// Highlight drop area when item is dragged over it
;['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, highlight, false)
})

;['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, unhighlight, false)
})

// Handle dropped files
dropArea.addEventListener('drop', handleDrop, false)

function preventDefaults(e) {
    e.preventDefault()
    e.stopPropagation()
}

function highlight(e) {
    dropArea.classList.add('highlight');
    emp.classList.add('bg-light');
}

function unhighlight(e) {
    dropArea.classList.remove('active');
    dropArea.classList.remove('highlight');
    emp.classList.remove('bg-light');
}

function hideElement(element) {
    element.classList.add('display-none');
}

function unHideElement(element) {
    element.classList.remove('display-none');
}

function handleDrop(e) {
    var dt = e.dataTransfer
    var files = dt.files

    handleFiles(files)
}

let uploadProgress = []
let progressBar = document.getElementById('progress-bar')
let totalFiles

function initializeProgress(numFiles) {
    unHideElement(progressBar);
    progressBar.value = 0
    uploadProgress = []

    for (let i = numFiles; i > 0; i--) {
        uploadProgress.push(0)
    }
}

function updateProgress(fileNumber, percent) {
    uploadProgress[fileNumber] = percent
    let total = uploadProgress.reduce((tot, curr) => tot + curr, 0) / uploadProgress.length
    progressBar.value = total
    // console.log(total, "total uploadProgress")
    if (total === 100) {
        setTimeout(() => hideElement(progressBar), 1000);
    }
}

function handleFiles(files) {
    if (files.length!==0){
        files = [...files]
        totalFiles = files.length
        initializeProgress(files.length)
        files.forEach(uploadFile)
        // files.forEach(previewFile)
        isExistImages();
    }
}

function previewFile(file) {
    let reader = new FileReader()
    reader.readAsDataURL(file)

    reader.addEventListener("load", function () {
        var image = new Image();
        image.onload = function () {
            console.log(this.width + " " + this.height, " image.onload");
        };

        image.addEventListener("load", function () {
            var imageInfo = file.name + ' ' +
                // image.width + '×' +
                // image.height + ' ' +
                file.type + ' ' +
                Math.round(file.size / 1024) + 'KB';

            console.log(imageInfo, " image.addEventListener")
            // Show image and info
            // elPreview.appendChild( this );
            // elPreview.insertAdjacentHTML("beforeend", imageInfo +'<br>');
            //
            // if (useBlob) {
            //     // Free some memory
            //     window.URL.revokeObjectURL(image.src);
            // }
        });
        // image.src = useBlob ? window.URL.createObjectURL(file) : reader.result;
    });

    reader.onloadend = function () {

        var imageInfo = file.name + ' ' +
            // image.width + '×' +
            // image.height + ' ' +
            file.type + ' ' +
            Math.round(file.size / 1024) + 'KB';

        console.log(imageInfo, " reader.onloadend")


        let img = document.createElement('img')
        img.src = reader.result

        // let btn = document.createElement('button');
        let div = document.createElement('div');
        div.className += " MdsPhoto MdsPhotos__item"
        let btn = document.createElement('div');
        btn.innerHTML = "<svg class=\"IconSvg IconSvg_trash IconSvg_size_24 MdsPhoto__icon MdsPhoto__icon_right\"><use xlink:href=\"#trash\"></use></svg>"
        // btn.className += " MdsPhoto__icon MdsPhoto__icon_right IconSvg_size_24"
        btn.onclick = () => {
            // this.element.removeChild(describeEl);
            console.log(this + " " + img.naturalWidth, "  btn.onclick");
        };

        div.appendChild(btn)
        document.getElementById('gallery')
            .appendChild(div)
            .appendChild(img)
        // document.getElementById('gallery').appendChild(btn)
        // .appendChild(btn)
        // document.getElementById('gallery').append(btn)

        img.onload = function () {
            console.log(img.naturalHeight + " " + img.naturalWidth, " img.onload");
        };
    }
}

function uploadFile(file, i, arr) {
    var url = '/cars/upload'
    var xhr = new XMLHttpRequest()
    var formData = new FormData()
    xhr.open('POST', url, true)
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest')

    // Update progress (can be used to show progress indicator)
    xhr.upload.addEventListener("progress", function (e) {
        updateProgress(i, (e.loaded * 100.0 / e.total) || 100)
    })

    xhr.addEventListener('readystatechange', function (e) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log("SUCCESS : ", xhr.responseText);

            // arr[i] = xhr.responseText;
            // file = xhr.responseText;

            // console.log("SUCCESS : ", this.getAllResponseHeaders());
            // console.log("SUCCESS : ", this.getResponseHeader("content-disposition"));

            updateProgress(i, 100) // <- Add this

            previewFileWithName(file, xhr.responseText);

        } else if (xhr.readyState == 4 && xhr.status != 200) {
            // Error. Inform the user
        }
    })

    formData.append('order', i)
    formData.append('files', file)
    formData.append('totalFiles', totalFiles)
    xhr.send(formData)
}


function previewFileWithName(file, name) {
    let reader = new FileReader()
    reader.readAsDataURL(file)

    reader.addEventListener("load", function () {
        var image = new Image();
        image.onload = function () {
            console.log(this.width + " " + this.height, " image.onload");
        };

        image.addEventListener("load", function () {
            var imageInfo = file.name + ' ' +
                // image.width + '×' +
                // image.height + ' ' +
                file.type + ' ' +
                Math.round(file.size / 1024) + 'KB';

            console.log(imageInfo, " image.addEventListener")
            // Show image and info
            // elPreview.appendChild( this );
            // elPreview.insertAdjacentHTML("beforeend", imageInfo +'<br>');
            //
            // if (useBlob) {
            //     // Free some memory
            //     window.URL.revokeObjectURL(image.src);
            // }
        });
        // image.src = useBlob ? window.URL.createObjectURL(file) : reader.result;
    });

    reader.onloadend = function () {

        var imageInfo = file.name + ' ' +
            file.type + ' ' +
            Math.round(file.size / 1024) + 'KB';
        // console.log(imageInfo, " reader.onloadend")


        let img = document.createElement('img')
        img.src = reader.result

        // let btn = document.createElement('button');
        let div = document.createElement('div');
        div.className += " MdsPhoto MdsPhotos__item"
        div.setAttribute('data-img', name);

        let btn = document.createElement('div');
        // btn.innerHTML = "<svg class=\"IconSvg IconSvg_trash IconSvg_size_24 MdsPhoto__icon MdsPhoto__icon_right\"><use xlink:href=\"#trash\"></use></svg>"

        // btn.innerHTML = "<a href = \"javascript:void(0)\" onClick = \"aClick(this)\">" +
        // "<svg className = \"IconSvg IconSvg_trash IconSvg_size_24 MdsPhoto__icon" +
        //     " MdsPhoto__icon_right\"><use xlink:href = \"#trash\" >< /use></svg></a>"

        btn.innerHTML = "<a\n" +
            "                href=\"javascript:void(0)\"\n" +
            "                onclick=\"aClick(this)\"\n" +
            "            >\n" +
            "              <svg\n" +
            "                  class=\"IconSvg IconSvg_trash IconSvg_size_24 MdsPhoto__icon MdsPhoto__icon_right\">\n" +
            "                <use xlink:href=\"#trash\"></use>\n" +
            "              </svg>\n" +
            "            </a>";

        // btn.onclick = () => {
        //     // this.element.removeChild(describeEl);
        //     console.log(this + " " + img.naturalWidth, "  btn.onclick");
        // };

        div.appendChild(btn)
        div.appendChild(img)


        var lastElem = gallery.lastElementChild;
        var isExistAddImgButton = lastElem?.hasAttribute('data-empty');
        console.log(lastElem);
        if (isExistAddImgButton) {
            // var previousSibling = lastChild.previousSibling;
            gallery.insertBefore(div, lastElem);
        } else {
            gallery.appendChild(div);
            addImgButton();
        }

        // addImgButton();


        // div.appendChild(btn)
        // document.getElementById('gallery')
        //     .appendChild(div)
        //     .appendChild(img)


        img.onload = function () {
            console.log(img.naturalHeight + " " + img.naturalWidth, " img.onload");
        };
    }
}


// todo проверить порядок добавления картинок по номеру
//  что если картинку добавили чуть позже
//  что если форму не сохранили, сохранённые картинки надо удалять,
//  перед закрытием сессии проверить или юзер нажал Cancel


// var gridDemo = document.getElementById('gridDemo');
//
// // Grid demo
// new Sortable(gridDemo, {
//     animation: 150,
//     ghostClass: 'blue-background-class'
// });


// var gallery = document.getElementById('gallery');
new Sortable(gallery, {
    animation: 150,
    ghostClass: 'blue-background-class'
});


var odometerInput = document.getElementById('odometer');
odometerInput.addEventListener('change', () => {
        if (odometerInput.value == "") {
            odometerInput.value = 1;
        }
    }
);


var imagesInput = document.getElementById('images');
document.getElementById('carform')
    .addEventListener('submit', submitForm);


function getNamesImages() {
    let listitems = [];
    listitems = Array.from(gallery.children)
        .filter(n => !n.hasAttribute('data-empty'))
        .map(n => n.dataset.img);
    return listitems;
}

function getCountImages() {
    return Array.from(gallery.children)
        .filter(n => !n.hasAttribute('data-empty'))
        .length > 0;
}


// return gallery.children?.length > 0;


function submitForm() {

    // уточнить порядок снимков
    let listitems = getNamesImages();
    let imagesValue;
    if (listitems.length == 1) {
        imagesValue = listitems[0];
    } else {
        imagesValue = listitems.join('|');
    }
    imagesInput.setAttribute('value', imagesValue);
}


function aClick(dataImg) {
    var parentElement = dataImg.parentElement.parentElement;
    let name = parentElement.getAttribute('data-img');
    console.log(name, " sendClick removeImg");
    sendClick(name, "/cars/removeImg", () => {
        console.log("sendClick removeImg");
        parentElement.remove();
        --totalFiles;
        if (!isExistImages()) {
            var lastElem = gallery.lastElementChild;
            var isExistAddImgButton = lastElem?.hasAttribute('data-empty');
            if (isExistAddImgButton) {
                lastElem.remove();
            }
        }
    })
}

function isExistImages() {
    // if (totalFiles > 0)
    if (totalFiles > 0 || getCountImages()) {
        hideElement(emp);
        return true;
    } else {
        unHideElement(emp);
        return false;
    }
}

function sendClick(value, url, callback) {
    var url = url
    var xhr = new XMLHttpRequest()
    var formData = new FormData()
    xhr.open('POST', url, true)
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest')

    xhr.addEventListener('readystatechange', function (e) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            callback();
        } else if (xhr.readyState == 4 && xhr.status != 200) {
            // Error. Inform the user
            console.log("Error sendClick");
        }
    })

    formData.append('value', value)
    xhr.send(formData)
}

function yearBuy() {
    let select = document.getElementById('yearPurchase');
    let yearNow = new Date().getFullYear();
    for (let i = yearNow; i > 1899; i--) {
        let option = document.createElement('option');
        option.value = i;
        option.text = i;
        select.appendChild(option);
    }
}

function addImgButton() {


    var lastElem = gallery.lastElementChild;
    var isExistAddImgButton = lastElem?.hasAttribute('data-empty');
    if (isExistAddImgButton) {
        // var previousSibling = lastChild.previousSibling;
        // gallery.insertBefore(div, lastElem);
        return;
    }


    // return;
    // let btn = document.createElement('button');
    let div = document.createElement('div');
    div.className += "PhotosAdd__wrapper PhotosAdd__withPhotos MdsPhotos__addButton PhotosAdd"
    div.setAttribute('data-empty', 'empty');
    div.addEventListener('click', () => inp.click());
    // div.click = function (){
    //     inp.click();
    // };

    let btn = document.createElement('div');

    div.innerHTML = " <div class=\"PhotosAdd__title\">\n" +
        "    <div class=\"PhotosAdd__icon\">\n" +
        "      <svg class=\"IconSvg_size_24\">\n" +
        "        <use xlink:href=\"#photo\"></use>\n" +
        "      </svg>\n" +
        "    </div>\n" +
        "    <div class=\"PhotosAdd__addButton\">Добавить фото</div>\n" +
        "  </div>";

    // btn.onclick = () => {
    //     // this.element.removeChild(describeEl);
    //     console.log(this + " " + img.naturalWidth, "  btn.onclick");
    // };

    // div.appendChild(btn)
    // document.getElementById('gallery')
    gallery.appendChild(div)
    // .appendChild(img)

}

// parent.insertBefore(child, parent.firstChild);
