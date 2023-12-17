

document.addEventListener('DOMContentLoaded', function () {

   const valores = window.location.search;
   const urlParams = new URLSearchParams(valores);

   var total_p1 = parseInt(urlParams.get('t1'));
   var total_p2 = parseInt(urlParams.get('t2'));
   var total_p3 = parseInt(urlParams.get('t3'));
   var total_p4 = parseInt(urlParams.get('t4'));
   var total_p5 = parseInt(urlParams.get('t5'));
   var fi = urlParams.get('fi');
   var ff = urlParams.get('ff');
   var cuenta = parseInt(urlParams.get('conteo'));
   
   var promedio_totales = (total_p1 + total_p2+ total_p3+ total_p4+ total_p5)/5;
   var promedio_mayor = (cuenta*5);
   var promedio_minimo = (promedio_mayor*80)/100;
   
   if (promedio_totales >= promedio_minimo){
      var color = "152,251,152,0.2";
   }else{
      var color = "200,0,0,0.2";
   }

   document.getElementById("p_titulo").innerText = urlParams.get('Nm');
   document.getElementById("fecha_inicio").value =fi;
   document.getElementById("fecha_fin").value =ff;

   var marksCanvas = document.getElementById("marksChart");

   var marksData = {
     labels: ["Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4", "Pregunta 5"],
     datasets: [{
       label: "Resultado Encuesta",
       backgroundColor: "rgba(" + color +")",
       data: [total_p1, total_p2, total_p3, total_p4, total_p5]
     }]
   };

   var radarChart = new Chart(marksCanvas, {
     type: 'radar',
     data: marksData
   });

});

function cerrar(){
   document.location.href = "index.html";
}
