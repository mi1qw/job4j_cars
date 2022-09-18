// ************************ Start ***************** //
var elementMark;
var elementModel;
document.addEventListener('DOMContentLoaded', (event) => {
    // elementModel = document.querySelector('.model select');
    // elementMark = document.querySelector('.mark select');
    addCheckboxes();
});

function addCheckboxes() {
    document.querySelectorAll('table input[type="checkbox"]')
        .forEach(n => {
            n.addEventListener('change', (e) => {
                sendClick("", '/myposts/status?id=' + n.id + '&value=' + n.checked,
                    () => {
                        console.log("checkbox status car id",n.id, n.checked)
                    });
            })
        })
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
    // formData.append('value', value)
    xhr.send(formData)
}