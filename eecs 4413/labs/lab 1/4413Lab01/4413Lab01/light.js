document.addEventListener('DOMContentLoaded', function () {
    /* 4413 23f Task 1 - write your code here */
    var l1 = "light #1 is on";
    var l2 = "light #2 is on";
    var l3 = "light #3 is on";
    var l4 = "light #4 is on";
    var l5 = "light #5 is on";
    var off = "all lights are off";

   

    function lightOn1() {
        document.getElementById('message').innerHTML = l1;
        document.getElementById('light').src = "images/light/light_1.jpg";
    }

    function lightOn2() {
        document.getElementById('message').innerHTML = l2;
        document.getElementById('light').src = "images/light/light_2.jpg";
    }

    function lightOn3() {
        document.getElementById('message').innerHTML = l3;
        document.getElementById('light').src = "images/light/light_3.jpg";
    }

    function lightOn4() {
        document.getElementById('message').innerHTML = l4;
        document.getElementById('light').src = "images/light/light_4.jpg";
    }

    function lightOn5() {
        document.getElementById('message').innerHTML = l5;
        document.getElementById('light').src = "images/light/light_5.jpg";
    }

    function lightOff() {
        document.getElementById('message').innerHTML = off;
        document.getElementById('light').src = "images/light/light_0.jpg";
    }

    document.getElementById('ON1').addEventListener('click', lightOn1);
    document.getElementById('ON2').addEventListener('click', lightOn2);
    document.getElementById('ON3').addEventListener('click', lightOn3);
    document.getElementById('ON4').addEventListener('click', lightOn4);
    document.getElementById('ON5').addEventListener('click', lightOn5);
    document.getElementById('off').addEventListener('click', lightOff);
});
