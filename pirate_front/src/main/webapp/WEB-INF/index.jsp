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
  <div id="title">
    <p >Relationship.img</p>
  </div>
  <div id = "formulaire">
    <table >
      <tr><td>Identifiant :</td><td><input required type="text" placeholder="Saisir votre identifiant"></td></tr>
      <tr><td>Mot de passe :</td><td><input required type="password" placeholder="**********"></td></tr>
      <tr><td colspan="2" align="center">Pas encore inscrit? <a id="lienInscription" href ="?inscription">Inscrivez-vous!</a></td></tr>
      <tr><td></td><td id="inscription"><input  class="new" name="Compte" type="radio" value="Pirate">Pirate <input class="new" name="Compte" value="Client" type="radio">Client</td></tr>

    </table>
  </div>
</div>
</form>


<script>
lienInscription.onclick = show;

function show()
{
  console.log("Show");
  inscription.style.display="block"
}


</script>
