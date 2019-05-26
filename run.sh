find ./com/avaj/simulation -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.avaj.simulation.Main scenario.txt