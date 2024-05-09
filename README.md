
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

- Assumptions
  - applied fast fail if input file data doesn't match to criteria specified
  
#### Domain Analysis
##### Models
  - Entity 
    - Party 
      - id
      - FullName
      - code

    - Constituency 
      - id
      - name
    - ElectionResult
      - id
      - constituencyName
      - Map<Party, Vote> to store the party with vote count 
  - valueObject
    - PartyName
      - stores mapping with party with party full name
  
##### Service
- ElectionResultEvaluator - it evaluates winner of constituency based on vote count 
  - return DTO Which has information of party like code, full name, vote count (winning party)

#### Controller
- ElectionDeskController  - it will call to fileProcessor to process and extract file content
  - processInputFile  - method which will call to the service to file processor  
- ConstituencyController - perform operation related with constituency information
  - create() - create new Constituency
  - get()  - getConstituency
- PartyController - it perform operations related with party information
  - create() - create new Party
  - get() - to get a party
- ElectionResultController - create a new election controller and
  - getWinnerOfConstituency() - get get the winner of constituency
  - returns the ElectionResultDto which contains winner party code , name, and votes


#### Service
- FileReaderService - it will read the content of the file line by line and
- FileParserService  - it will parse the file and validate the data and creates objects
  - parseInputLine - it will parse file line by line and creates object
- PartyService - it will create a new party 
  - getFullNameOfParty() - get full name of the party
- ElectionResultService - it will actually call to domain service to calculate the winners
  - stores all the information of party and vote count
  - gives the winner of constituency DTO
- ConstituencyService - create a new Constituency

#### Repository 
- PartyRepository - stores the entire party information in
- ConstituencyRepository - to store the constituencies information 
- ElectionResultRepository - stores the constituency and party with vote count information

#### Database 
- Used a FakeInMemoryDatabase to store the party, constituencies, election result database








