package site.pengcheng.effectivejava.ch6;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/17 2:18 下午
 */
public class PlantMain {

    private static enum  UpdataResult {PENDIN, SUCCESS, FAIL, PASS}

    public static void main(String[] args) {
        System.out.println(UpdataResult.PENDIN.ordinal());
    }

    private void poorMethod() {
        List<Plant> garden = new ArrayList<>(1000);

        Set<Plant>[] plantsByLifeCycle = new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i ++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        // don't do this
        for (Plant plant: garden) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }
    }

    private void betterMethod() {
        Map<Plant.LifeCycle, Set<Plant>>  plantsByLifeCycle = new EnumMap<Plant.LifeCycle, Set<Plant>>(Plant.LifeCycle.class);
        List<Plant> garden = new ArrayList<>(1000);

        for (Plant.LifeCycle lifeCycle: Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant plant: garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        System.out.println(plantsByLifeCycle);
    }


}
