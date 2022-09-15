// ************************ Start ***************** //
document.addEventListener('DOMContentLoaded', (event) => {
    addyears();
    addEngineDisplacement();
    clearInput();
});

let inp = document.getElementById('fileElem');

function addyears() {
    document.querySelectorAll('.yearFrom select:last-child').forEach(n => {
        year(n);
        // console.log(element);
    });
}

function addEngineDisplacement() {
    document.querySelectorAll('.displacementFrom select:last-child').forEach(n => {
        EngineDisplacement(n);
        // console.log(element);
    });
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

function year(select) {
    let yearNow = new Date().getFullYear();
    for (let i = yearNow; i > 1899; i--) {
        let option = document.createElement('option');
        option.value = i;
        option.text = i;
        select.appendChild(option);
    }
}

function EngineDisplacement(select) {
    let yearNow = new Date().getFullYear();
    for (let i = 200; i < 3000; i += 200) {
        let option = document.createElement('option');
        option.value = i;
        option.text = (i / 1000).toFixed(1) + ' л';
        select.appendChild(option);
    }
    for (let i = 3000; i < 8000; i += 500) {
        let option = document.createElement('option');
        option.value = i;
        option.text = (i / 1000).toFixed(1) + ' л';
        select.appendChild(option);
    }
}

function clearInput() {


    Array.prototype.forEach.call(document.querySelectorAll('.clearable-input'), function (el) {
        var input = el.querySelector('input');

        conditionallyHideClearIcon();
        input.addEventListener('input', conditionallyHideClearIcon);
        el.querySelector('[data-clear-input]').addEventListener('click', function (e) {
            input.value = '';
            conditionallyHideClearIcon();
        });

        function conditionallyHideClearIcon(e) {
            let target = input || (e && e.target);
            target.nextElementSibling.style.display = target.value ? 'block' : 'none';
        }
    });


    // console.log("sss");
    // document.querySelectorAll('clearable-input').forEach((n) => {
    //     console.log(n);
    //     let input = n.querySelector('input');
    //     console.log(input);
    //     input.addEventListener('input', conditionallyHideClearIcon);
    //     n.querySelector('[data-clear-input]')
    //         .addEventListener('click', function (e) {
    //             n.value = '';
    //             conditionallyHideClearIcon();
    //         });
    //
    //
    // });


}

function conditionallyHideClearIcon(e) {
    var target = (e && e.target) || input;
    target.nextElementSibling.style.display = target.value ? 'block' : 'none';
}