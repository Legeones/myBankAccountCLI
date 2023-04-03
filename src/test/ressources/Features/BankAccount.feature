Feature: Hola como estas
  En tant que client de la banque Universite
  Je veux pouvoir gerer mon compte banquaire
  Afin de controler mes depenses par rapport à ce que je gagne de mon travail et a ce que je retire pour effectuer mes paiements

  @Depot
  Scenario Outline: Deposer avec succes
    Given je suis sur la page de transaction avec un <solde> dans mon compte
    When je remplis le champ avec un <montant>
    And je clique sur Deposer
    Then je devrais voir un message de resultat effectue avec succes le solde <attendu>

    Examples:
      | solde | montant | attendu |
      | 10    | 100     | 110     |
      | 0     | 2000    | 2000    |

  @Retrait
  Scenario Outline: Retirer avec succes
    Given je suis sur la page de transaction avec un <solde> dans mon compte
    When je remplis le champ avec un <montant>
    And je clique sur retirer
    Then je devrais voir un message de resultat effectue avec succes le solde <attendu>

    Examples:
      | solde | montant | attendu |
      | 100   | 10      | 90      |
      | 2000  | 1000    | 1000    |

  @RetraitNegatif
  Scenario Outline: Solde negatif apres retrait alert
    Given je suis sur la page de transaction avec un <solde> dans mon compte
    When je remplis le champ avec un <montant>
    Then je devrais avoir une exception de solde négatif

    Examples:
      | solde | montant |
      | 200   | 300     |
      | 1     | 2       |

  @SoldeBon
  Scenario Outline: Le solde est correcte
    Given je suis sur la page de transaction avec un <solde> dans mon compte
    Then le solde doit etre correcte <res>

    Examples:
      | solde | res |
      | 100   | 100 |
      | 0     | 0   |