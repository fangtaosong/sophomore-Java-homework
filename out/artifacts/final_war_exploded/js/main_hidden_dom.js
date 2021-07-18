var look_mode_span=document.getElementById("look_mode_span");
var edit_mode_span=document.getElementById("edit_mode_span");
var look_mode=document.getElementById("look_mode");
var change_mode=document.getElementById("change_mode");
change_mode.style.display="none"
look_mode_span.addEventListener("click", function (){
    look_mode.style.display="block"
    change_mode.style.display="none"

})
edit_mode_span.addEventListener("click", function (){
    look_mode.style.display="none"
    change_mode.style.display="block"

})


