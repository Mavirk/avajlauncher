find ./avaj/simlulation -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.avaj.simulation.Main avaj/scenario.txt
