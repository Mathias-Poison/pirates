<style>
  #base
  {
    display: flex;
    justify-content:center;
    align-items: center;
    height: 100%;
  }

  #title,formulaire
  {
    flex-direction: column;

  }
#inscription
{
  display: none;
  cursor:pointer;
}

#lienInscription
{
  cursor:pointer;
}


</style>
<form >

<div id="base">
  <div id = "enchere">
    <table border >
      <thead>
         <tr>
                <th>Numéro enchère</th>
                <th>Client</th>
                <th>Montant de base</th>
                <th>Montant enchéri</th>
                <th>le</th>
                <th>Dernier montant enchéri</th>
                <th>le</th>
                <th>Deadline</th>
            </tr>
       </thead>
       <tbody>
         <tr>
           <td>Enchere 1 </td>
           <td>DSK</td>
           <td>10 000PO</td>
           <td>9 800PO</td>
           <td>12/12/12</td>
           <td>9 500PO</td>
           <td>13/12/12</td>
           <td><p id="timer1">00:00</p></td>
         </tr>
         <tr>
           <td>Enchere 2 </td>
           <td>Poutine</td>
           <td>15 000PO</td>
           <td>12 000PO</td>
           <td>11/11/11</td>
           <td>11 800PO</td>
           <td>11/11/11</td>
           <td><p id="timer2">Fin dans x heures</td>
         </tr>
       </tbody>

    </table>
  </div>
</div>
</form>


<script>
  // Définir la durée du timer en secondes
  var timerDuration1 = 120;
  var timerDuration2 = 500;
  // Obtenir l'élément HTML pour afficher le timer
  var timerElement1 = document.getElementById("timer1");
  var timerElement2 = document.getElementById("timer2");

  // Définir la fonction pour mettre à jour le timer
  function updateTimer1() {
    var minutes = Math.floor(timerDuration1 / 60);
    var seconds = timerDuration1 % 60;
    timerElement1.innerHTML = ("0" + minutes).slice(-2) + ":" + ("0" + seconds).slice(-2);
    timerDuration1--;

    // Arrêter le timer lorsque le temps est écoulé
    if (timerDuration1 < 0) {
      clearInterval(timerInterval1);
      timerElement1.innerHTML = "Temps écoulé !";
    }
  }

  function updateTimer2() {
    var minutes = Math.floor(timerDuration2 / 60);
    var seconds = timerDuration2 % 60;
    timerElement2.innerHTML = ("0" + minutes).slice(-2) + ":" + ("0" + seconds).slice(-2);
    timerDuration2--;

    // Arrêter le timer lorsque le temps est écoulé
    if (timerDuration2 < 0) {
      clearInterval(timerInterval2);
      timerElement2.innerHTML = "Temps écoulé !";
    }
  }

  // Mettre à jour le timer toutes les secondes
  var timerInterval1 = setInterval(updateTimer1, 1000);
  var timerInterval2 = setInterval(updateTimer2, 1000);

</script>
