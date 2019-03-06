# Pokalabių aplikacija, veikianti tinklalapių naršyklėje.
## Įvadas
Tai yra žiniatinklio aplikacijos, skirtos pokalbiams tarp registruotų vartotojų, aprašymas. Pokalbyje gali dalyvauti tik savo paskyrą turintis vartotojai, todėl vartotojas pirmiausia turi susikurti naują paskyrą, naudodamas unikalų vartotojo vardą ir apsaugodamas paskyrą slaptažodžiu. Bendravimas tarp vartotojų vyksta viename bendrame "kambaryje".

## Funkciniai reikalavimai

#### 1. Naujas vartotojas, norėdamas dalyvauti pokalbyje, turi susikurti savo paskyrą, užpildydamas tokius formos laukus:
* vartotojo vardas (username) - unikalus, būtinas
* vartotojo slaptažodis - būtinas
* vartotojo slapyvardis (nickname) - unikalus, nebūtinas (kai neužpildytas, aplikacija naudoja vartotojo vardą)

#### 2. Įėjęs į aplikaciją varototjas, gali keisti šiuos savo paskiros duomenis:
* vartotojo slaptažodį
* vartotojo slapyvardį

#### 2. Vartotojai, jau turintys savo paskyrą, norėdami dalyvauti pokalbyje, turi prisijungti prie aplikacijos, įvesdami savo vartotojo vardą ir slaptažodį.

#### 3. Įėjusiems į aplikaciją vartotojams pateikiamas du teksto laukai:
* teksto išvesties laukas, kuriame vaizuojamos visų vartotojų įvestos žinutės, sudarytos iš:
 - žinutės įvesties laiko
 - žinutės autoriaus slapyvardžio (vartotojo vardo, jei vartotojas slapyvardžio nenurodė)
 - žinutės teksto
* teksto įvesties laukas, kuriame vartotojas įveda žinutės tesktą ir išsiunčia paspaudęs ENTER klavišą