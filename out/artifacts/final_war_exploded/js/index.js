var a=document.getElementsByClassName('submit_btn')[0]
// a.addEventListener("click", function(){
//     const name=document.getElementById("xuehao").value
//     const password=document.getElementById("password").value
//     alert(name+password)
//     var a="<%=javaParam%>";
// });
var choose=0;
function change1() {
    var a=document.getElementsByClassName("current_li")[0]
    console.log(a.classList);
    a.classList.remove("current_li");
    a.classList.remove("current");
    var b=document.getElementById("me_1")
    b.classList.add("current_li");
    b.classList.add("current");
    choose=0;
    var c=document.getElementsByClassName("con_1")[0]
    var d=document.getElementsByClassName("con_2")[0]
    d.style.display="none"
    c.style.display=""


}
function change2() {
    var a=document.getElementsByClassName("current_li")[0]
    a.classList.remove("current_li");
    a.classList.remove("current");
    var b=document.getElementById("me_2")
    b.classList.add("current_li");
    b.classList.add("current");
    choose=1
    var c=document.getElementsByClassName("con_1")[0]
    var d=document.getElementsByClassName("con_2")[0]
    c.style.display="none"
    d.style.display=""

}
