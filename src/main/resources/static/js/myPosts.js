// ************************ Start ***************** //
document.addEventListener('DOMContentLoaded', (event) => {
    addCheckboxes();
});

function addCheckboxes() {
    document.querySelectorAll('table input[type="checkbox"]')
        .forEach(n => {
            n.addEventListener('change', (e) => {
                if (n.checked){
                    n.setAttribute("checked", "checked")
                    n.classList.add('checkboxStatus');
                }
                else{
                    n.removeAttribute("checked");
                    n.classList.remove('checkboxStatus');
                }

                sendClick("", '/myposts/status?id=' + n.id + '&value=' + n.checked,
                    () => {
                        console.log("checkbox status car id", n.id, n.checked)
                    });
            })
        })
}

function sendClick(value, url, callback) {
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
