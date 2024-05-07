
#### Election Results

It's election night! Exciting! We have a feed of election results from a data supplier. <br>
They will supply us a file which will be updated throughout the night as results come in. <br>

A result will consist of:
- A constituency
- A repeating set of pairs with the party code and the votes cast

So for example:

Bangalore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP  <br>
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

Party Codes -

BJP - Bhartiya Janta Party   <br>
INC - Indian National Congress <br>
BSP - Bahujan Samaj Party <br>
CPI - Communist Party of India <br>
NCP - Nationalist Congress Party <br>
IND - Independant <br>

We want to transform this into a standard result that shows:

- the constituency name
- translates the party code into a full name
- shows the winner of the constituency



### Analysis

#### Controller
- ElectionDeskController  - it will call to fileProcessor to process and extract file content
  - processInputFile  - method which will call to the service to fileprocessor  



#### Service
- FileReaderService - it will read the content of the file line by line and
- FileParserService  - it will parse the file and validate the data and creates objects
  - parseInputLine - it will parse file line by line and creates object







