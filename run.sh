find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.simulation.Main avaj/scenario.txt