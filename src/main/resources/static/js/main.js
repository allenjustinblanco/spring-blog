var sheet = "/css/main.css";
function swapStyleSheet(){
    if(sheet === "/css/main.css"){
        document.getElementById("pagestyle").setAttribute("href", sheet);
    } else {
        document.getElementById("pagestyle").setAttribute("href", "/css/dark.css");
    }
}