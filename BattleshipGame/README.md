# BattleShip Game Assignment

#Steps to Run the Application

<ul>
<li>Import the maven project: BattleShipGame. </li>
<li>Run the maven command: mvn clean install to install all the maven dependencies used for writing the test cases.</li>
<li>Run the code from the main file: BattleShipGame.java. </li>
<li>See the console output for response based on input.txt present in src/main/resources.  </li>
</ul>

#Input

5 E <br />
2 <br />
Q 1 1 A1 B2 <br />
P 2 1 D4 C3 <br />
A1 B2 B2 B3 <br />
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5 <br />

#Expected Output

Player-1 fires a missile with target A1 which got miss <br />
Player-2 fires a missile with target A1 which got hit <br />
Player-2 fires a missile with target B2 which got miss <br />
Player-1 fires a missile with target B2 which got hit <br />
Player-1 fires a missile with target B2 which got hit <br />
Player-1 fires a missile with target B3 which got miss <br />
Player-2 fires a missile with target B3 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target A1 which got hit <br />
Player-2 fires a missile with target D1 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target E1 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target D4 which got hit <br />
Player-2 fires a missile with target D4 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target D5 which got hit <br />
Player-2 won the battle <br />

#Actual Output
Welcome to Battle Ship! Initiating the game! <br />
Player-1 fires a missile with target A1 which got miss <br />
Player-2 fires a missile with target A1 which got hit <br />
Player-2 fires a missile with target B2 which got miss <br />
Player-1 fires a missile with target B2 which got hit <br />
Player-1 fires a missile with target B2 which got hit <br />
Player-1 fires a missile with target B3 which got miss <br />
Player-2 fires a missile with target B3 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target A1 which got hit <br />
Player-2 fires a missile with target D1 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target E1 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target D4 which got hit <br />
Player-2 fires a missile with target D4 which got miss <br />
Player-1 has no more missiles left to launch <br />
Player-2 fires a missile with target D5 which got hit <br />
Player-2 won the battle <br />



