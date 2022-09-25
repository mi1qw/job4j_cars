const slideGallery = document.querySelector('.slides');
const slides = slideGallery.querySelectorAll('div');
const scrollbarThumb = document.querySelector('.thumb');
const slideCount = slides.length;
const slideHeight = 720;
const marginTop = 16;

const scrollThumb = () => {
    const index = Math.floor(slideGallery.scrollTop / slideHeight);
    scrollbarThumb.style.height = `${((index + 1) / slideCount) * slideHeight}px`;
};

const scrollToElement = el => {
    const index = parseInt(el.dataset.id, 10);
    slideGallery.scrollTo(0, index * slideHeight + marginTop);
};

document.querySelector('.thumbnails').innerHTML += [...slides]
    .map(
        (slide, i) => `<img src="${slide.querySelector('img').src}" data-id="${i}">`
    )
    .join('');

document.querySelectorAll('.thumbnails img').forEach(el => {
    el.addEventListener('click', () => scrollToElement(el));
});

slideGallery.addEventListener('scroll', e => scrollThumb());

scrollThumb();


// Open the Modal
function openModal() {
    console.log("modal-dialog", document.getElementById('modal-dialog'))
    document.getElementById('modal-dialog').style.display = "block";
}

// Close the Modal
function closeModal() {
    console.log("modal-dialog", document.getElementById('modal-dialog'))
    document.getElementById('modal-dialog').style.display = "none";
}