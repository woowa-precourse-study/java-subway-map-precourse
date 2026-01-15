package subway.domain;

import java.util.*;

public class Section {

    private Map<String, List<String>> sections = new HashMap<>();

    public Section(){}

    public void addSection(String line, List<String> stations) {
        sections.put(line,stations);
    }

    public  void validateNotStationInLine(String name){
        for (List<String> stations:sections.values()){
            if (stations.contains(name)){
                throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
            }
        }
    }

    public void addSectionStation(String line,int order, String station){
        sections.get(line).add(order+1,station);
    }


    public void deleteSectionStation(String line, String station) {
        validateSectionMinimum(line);
        boolean removed = sections.get(line).remove(station);
        if (!removed) {
            throw new IllegalArgumentException("[ERROR] 해당 역이 노선에 존재하지 않습니다.");
        }
    }

    public Map<String, List<String>> getSections() {
        return Collections.unmodifiableMap(sections);
    }


    public void validateSection(String line){
        if (sections.containsKey(line)){
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
    }

    public void validateSectionExist(String line){
        if (!sections.containsKey(line)){
            throw new IllegalArgumentException("[ERROR] 해당 노선이 존재하지 않습니다.");
        }
    }

    public void validateSectionMinimum(String line){
        if (sections.get(line).size()<=2){
            throw new IllegalArgumentException("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
    }


}
