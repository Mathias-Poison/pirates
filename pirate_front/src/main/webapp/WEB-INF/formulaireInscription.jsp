<meta charset="utf-8">

<form>

  <fieldset>
    <legend>Informations personnelles </legend>
    <table>
      <tr><td>Vous êtes : </td><td><input name="Type_compte" type="radio" value="Pirate">Pirate <input name="Type_compte" value="Client" type="radio">Client</td></tr>
      <tr><td>Login :</td><td><input required type="text" placeholder="Saisir votre login"></td></tr>
      <tr><td>Mot de passe </td><td><input required type="password" placeholder="**********"></td></tr>
      <tr><td>Confirmation Mot de passe </td><td><input required type="password" placeholder="**********"></td></tr>
      <tr><td>Email </td><td><input type="email" placeholder="pirate@mail.fr"></td></tr>
      <tr><td>Date de naissance </td><td><input type="date" value="1500-01-01"></td></tr>
      <tr><td>Pseudonyme </td><td><input required type="text" placeholder="Saisir votre Pseudonyme"></td></tr>
      <tr><td>Sexe</td><td>
        <select>
          <option selected>Femme</option>
          <option>Homme</option>
        </select>
      </td></tr>
      <tr><td>Date de naissance </td><td><input type="date" value="2000-01-01"></td></tr>
    </table>
  </fieldset>

  <fieldset>
    <legend>Préférences </legend>
    <table>
      <tr><td>Couleur favorite</td><td><input name="Couleur favorite" type="radio" value="Rouge">Rouge <input name="Couleur favorite" value="Vert" type="radio">Vert<input name="Couleur favorite" type="radio" value="Bleu">Bleu</td></tr>
      <tr><td>Centre d'intérêts</td><td><input type="checkbox">Sport<input type="checkbox">Danse<input type="checkbox">Musique<input type="checkbox">Informatique</td></tr>
    </table>
  </fieldset>

  <fieldset>
    <legend>Commentaires </legend>
    <table>
      <tr><td>Message </td><td> <textarea placeholder="" cols="23" rows="3"></textarea>
      </table>
    </fieldset>
    <input type="submit" value="Envoyer">
