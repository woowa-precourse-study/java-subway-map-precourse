package subway.util;

public final class InputParser {

    private InputParser() {
    }

    public static String parseStation(String station) {
        station = station.strip();

        Validator.validateStationFormat(station);
        return station;
    }

    public static String parseLine(String line) {
        line = line.strip();

        Validator.validateLineFormat(line);
        return line;
    }

    public static int parseIndex(String readIndex) {
        readIndex = readIndex.strip();

        Validator.validateIndexFormat(readIndex);

        return NumberConvertor.convertToNumber(readIndex);
    }
}
