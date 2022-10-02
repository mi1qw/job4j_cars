// ************************ Start ***************** //
var elementMark;
var elementModel;
var elementResetBtn;
document.addEventListener('DOMContentLoaded', (event) => {
    elementMark = document.querySelector('.mark select');
    elementModel = document.querySelector('.model select');
    elementResetBtn = document.querySelector('.resetBtn');
    addyears();
    addEngineDisplacement();
    clearInput();
    clearSelect();
    addModels();
    resetBtn();
    clearResetBtn();
});


function addyears() {
    document.querySelectorAll('.yearFrom select').forEach(n => {
        year(n);
        // console.log(element);
    });
}

function addEngineDisplacement() {
    document.querySelectorAll('.displacementFrom select').forEach(n => {
        EngineDisplacement(n);
        // console.log(element);
    });
}

function addModels() {
    elementMark.addEventListener('change', (e) => {
        if (elementMark.value) {
            clearResetBtn();
            sendClick('id', elementMark.value,
                '/cars/models?id=' + elementMark.value,
                (e) => {
                    cleanModels()
                    var models = JSON.parse(e.target.response);
                    var map = new Map(Object.entries(models));
                    map.forEach((k, v) => {
                        elementModel.appendChild(new Option(k, v));
                    })
                }
            );
        } else {
            cleanModels();
        }
    })
}

function cleanModels() {
    elementModel.classList.remove('filter-select');
    while (elementModel.options.length > 1) {
        elementModel.remove(1);
    }
}

function sendClick(nameValue, value, url, callback) {
    var xhr = new XMLHttpRequest()
    var formData = new FormData()
    xhr.open('GET', url, true)
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest')
    xhr.addEventListener('readystatechange', function (e) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            callback(e);
        } else if (xhr.readyState == 4 && xhr.status != 200) {
            // Error. Inform the user
            console.log("Error sendClick");
        }
    })
    // formData.append(nameValue, value)
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
            if (target.value) {
                input.classList.add('filter-select');
            } else {
                input.classList.remove('filter-select');
            }
            clearResetBtn();
        }
    });
}

function clearSelect() {
    Array.prototype.forEach.call(document.querySelectorAll('.clearable-select'), function (el) {
        var select = el.querySelector('select');

        conditionallyHideClearIcon();
        select.addEventListener('change', conditionallyHideClearIcon);
        el.querySelector('[data-clear-input]').addEventListener('click', function (e) {
            select.value = '';
            select.selectedIndex = 0;
            select.classList.remove('filter-select');
            conditionallyHideClearIcon();
            if (select == elementMark) {
                cleanModels();
            }
        });

        function conditionallyHideClearIcon(e) {
            let target = select || (e && e.target);
            target.nextElementSibling.style.display =
                target.value ? 'block' : 'none';

            if (target.value == "") {
                target.classList.remove('filter-select');
                target.selectedIndex = 0;
            } else {
                target.classList.add('filter-select');
            }
            clearResetBtn();
        }
    });
}


resetBtn = () => {
    document.querySelector('.resetBtn').addEventListener('click',
        e => {
            document.querySelectorAll('.clearable-select *[data-clear-input], .clearable-input' +
                ' *[data-clear-input]')
                .forEach(n => n.click());

            document.getElementById('form-filter').reset();

            document.querySelectorAll('.clearable-select select')
                .forEach(n => {
                    // console.log('selectedIndex', n.options.selectedIndex);
                    n.options[n.selectedIndex].removeAttribute('selected');
                });


            document.querySelectorAll('.clearable-input input')
                .forEach(n => {
                    n.setAttribute('value', '');
                });
            clearResetBtn();
        });

};

isCheckedFields = () => {
    let flag = false;
    let nodeListOf = document.querySelectorAll('.clearable-select select');
    Array.from(nodeListOf)
        .every(n => {
            if (n.selectedIndex != 0) {
                flag = true;
                return false;
            }
            return true;
        });
    if (!flag) {
        nodeListOf = document.querySelectorAll('.clearable-input input');
        Array.from(nodeListOf)
            .every(n => {
                if (n.value) {
                    flag = true;
                    return false;
                }
                return true;
            });
    }
    return flag;
}


function clearResetBtn() {
    if (isCheckedFields()) {
        elementResetBtn.classList.remove('display-none');
    } else {
        elementResetBtn.classList.add('display-none');
    }
}