# ComputerForm
## Īsumā par aplikāciju
:hatching_chick: Aplikācija sastāv no divām tabulām
- Datora Detaļas (ComputerPart)

- Datora Detaļas Pieteikuma (CompuerForm)

### Datora Detaļa(ComputerPart)
Tā sastāv no Detaļas Id, Detaļas Tips, Detaļas Firma, Detaļas Modelis
- Detaļas Tips sastāv no enum vērtībām, kuras šajā mājasdarbā ir: CPU, MONITOR, RAM, GPU, KEYBOARD, MOUSE. 

### Datora Detaļas Pieteikums(ComputerForm)
Tā sastāv no Pieteukuma Id, Detaļas, Pieteikuma iemesls, Pieteiktais laiks

#### LAI VEICINĀTU APLIKĀCIJAS DARBĪBU NEPIECIEŠAMAM JĀBŪT UZINSTALĒTAM MAVEN, MĀJASDARBĀ TIKA IZMANTOTS POSTGRESQL DB(dbeaver kā aplikācijas rīks) KĀ ARĪ DOCKER COMPOSE.

:hatching_chick: Pirmais Solis: Noklonēt repositoriju un navigēties uz mapi caur CMD, kurā tika projekts noklonēts un ievadīt zemāk norādīto komandu iekš CMD
          
    mvn package -Dmaven.test.skip=true
    
Šī komanda izveidos .jar file iekš target mapes jūsu noklonētajā projektā.

:hatching_chick: Otrais Solis: Lai palaistu aplikāciju caur Docker compose nepieciešams ievadīt zemāk norādīto komandu iekš CMD

    docker compose up
    
Šī komanda izveidos nepieciešamos imidžus kā arī konteinerus iekš jūsu Docker kā arī savienosies ar datubāzi. 

## FRONTEND DAĻAS PALAIŠANA

#### FRONTEND DAĻĀ TIKA IZMANTOTS ANGULAR. 

:hatching_chick: Lai veiktu frontend daļas palaišanu ir nepieciešams noklonēt repositoriju no šī linka https://github.com/Divjee/ComputerFormUi un ar CMD navigēties uz mapi, kuŗā esat noklonējis projektu.

:hatching_chick: Lai veiktu projekta palaišanu caur CMD ir nepieciešams ievadīt ng serve un atvērt šo linku http://localhost:4200/

##### Pēc fronted daļas palaišanas, mēs tagad varam izmantot aplikāciju 
###### Zemāk norādītais video parāda kā mēs varam izmantot aplikāciju. 

https://user-images.githubusercontent.com/99561972/213956704-3a5ca0bd-a7dc-4bbb-bf65-07da60469fd5.mp4



  
