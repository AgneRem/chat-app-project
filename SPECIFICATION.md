# Pokalabių aplikacija, veikianti tinklalapių naršyklėje.
## Įvadas
Tai yra žiniatinklio aplikacijos, skirtos pokalbiams tarp registruotų vartotojų, aprašymas. Pokalbyje gali dalyvauti tik savo paskyrą turintis vartotojai, todėl vartotojas pirmiausia turi susikurti naują paskyrą, naudodamas unikalų vartotojo vardą ir apsaugodamas paskyrą slaptažodžiu. Bendravimas tarp vartotojų vyksta viename bendrame "kambaryje".

## Funkciniai reikalavimai
#### 1. Naujas vartotojas, norėdamas dalyvauti pokalbyje, turi susikurti savo paskyrą, užpildydamas tokius formos laukus:
* vartotojo vardas (username) - unikalus, būtinas
* vartotojo slaptažodis - būtinas
* vartotojo slapyvardis (nickname) - unikalus, nebūtinas

#### 2. Vartotojas, jau turintis savo paskyrą, norėdamas dalyvauti pokalbyje, turi prisijungti prie aplikacijos, įvesdamas savo vartotojo vardą ir slaptažodį.

#### 3. Įėjusiam į aplikaciją vartotojui pateikiami tokie sąsajos elementai:
* teksto išvesties laukas, kuriame vaizduojamos visų vartotojų įvestos žinutės, sudarytos iš:
  - žinutės įvesties laiko
  - žinutės autoriaus slapyvardžio (vartotojo vardo, jei vartotojas slapyvardžio nenurodė)
  - žinutės teksto
* teksto įvesties laukas, kuriame vartotojas įveda žinutės tesktą ir išsiunčia, paspaudęs ENTER klavišą
* vartojo meniu savo paskyros duomenų tvarkymui

#### 4. Varototjas, gali keisti šiuos savo paskyros duomenis:
* vartotojo slaptažodį
* vartotojo slapyvardį (nickname)

#### 5. Vartotojų paskyrų slaptažodžiai saugomi užšifruoti.

#### 6. Vartotojui ištrynus savo paskykrą, jo žinutės neištrinamos, bet pažymimos taip, kad matytų kiti pokalbio dalyviai.

## Nefunkciniai reikalavimai
#### Aplikacija kuriama, panaudojus šias technologijas:
##### Backend dalis:
* Java 8
* Spring Boot
* Reliacinė duomenų bazė H2
##### Frontend dalis:
* React
