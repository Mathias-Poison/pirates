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

<form action="/connexion">

<div id="base">
  <div id="title">
    <p >Relationship.img</p>
  </div>
  <div id = "formulaire">
    <table >
      <tr><td>Identifiant :</td><td><input name="login" required type="text" placeholder="Saisir votre identifiant"></td></tr>
      <tr><td>Mot de passe :</td><td><input name="password" required type="password" placeholder="**********"></td></tr>
      <tr><td colspan="2" align="center">Pas encore inscrit? <a id="lienInscription" href ="/formulaireinscription">Inscrivez-vous!</a></td></tr>

    </table>
  </div>
</div>
</form>


<script>
lienInscription.onclick = show;


</script>
