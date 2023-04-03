package Steps;

import TD1.BankAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountSteps {
    private BankAccount bankAccount;
    private double i_montant;
    private boolean exception;
    @Given("je suis sur la page de transaction avec un {} dans mon compte")
    public void je_suis_sur_la_page_transaction(double solde){
        bankAccount = new BankAccount(solde);
    }
    @When("je remplis le champ avec un {}")
    public void je_remplis_le_champ_avec_un_montant(double montant){
        i_montant = montant;
    }
    @And("je clique sur Deposer")
    public void je_clique_sur_deposer(){
        bankAccount.deposit(i_montant);
    }
    @And("je clique sur retirer")
    public void je_clique_sur_retirer(){
        bankAccount.withdraw(i_montant);
    }
    @Then("je devrais voir un message de resultat effectue avec succes le solde {}")
    public void je_devrais_voir_un_message_de_depot_effectue_avec_succes(double attendu){
        assertEquals(attendu, bankAccount.checkBalance());
        // System.out.println("Vous avez effectuer une transaction de "+i_montant+" et vous avez désormais un solde de "+bankAccount.checkBalance());
    }

    @Then("je devrais avoir une exception de solde négatif")
    public void je_devrais_avoir_une_exception_de_solde_négatif(){
        assertThrows(Exception.class, () -> {
            bankAccount.withdraw(i_montant);
        });
    }

    @Then("le solde doit etre correcte {}")
    public void le_solde_doit_etre_correcte(double attendu){
        assertEquals(attendu, bankAccount.checkBalance());
    }


}
