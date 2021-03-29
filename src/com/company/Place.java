//package com.company;
//
//import Weapons_Package.Weapon;
//
//import java.util.LinkedList;
//
//public class Place {
//
//    private String placeName;
//    private final int monsterCount;
//    private final LinkedList<Monster> monsters;
//    private final Human human;
//
//
//    public Place(int x, Human human) {
//        this.monsters = new LinkedList<>();
//
//        if (x == 1) {
//
//            this.placeName = "Dungeon";
//        } else if (x == 2) {
//
//            this.placeName = "Temple";
//        } else {
//
//            System.out.println("Please enter 1 or 2");
//        }
//        this.monsterCount = human.getLevel() * 2;
//
//        this.human = human;
//        createMonster();
//
//
//    }
//
//    private void createMonster() {
//
//        Weapon monsterWeapon;
//        for (int i = 0; i < this.monsterCount; i++) {
//
//            if (this.placeName.equals("Dungeon")) {
//
//                int monsterHealth = human.getLevel() * 10 + 100;
//                if (human.getLevel() == 1) {
//
//                     monsterWeapon = new Weapon("punch");
//
//                } else if (human.getLevel() == 2) {
//
//                    monsterWeapon = new Weapon("knife");
//
//                } else if (human.getLevel() == 3) {
//
//                    monsterWeapon = new Weapon("sword");
//
//                } else {
//
//                    monsterWeapon = new Weapon("long sword");
//
//                }
//
//
//                Monster monster = new Monster("Minotaur", human.getLevel(), monsterHealth,monsterWeapon );
//                monsters.add(monster);
//            }
//
//            if (this.placeName.equals("Temple")) {
//
//                int monsterHealth = human.getLevel() * 20 + 100;
//                if (human.getLevel() == 1) {
//
//                    monsterWeapon = new Weapon("punch");
//
//                } else if (human.getLevel() == 2) {
//
//                    monsterWeapon = new Weapon("knife");
//
//                } else if (human.getLevel() == 3) {
//
//                    monsterWeapon = new Weapon("sword");
//
//                } else {
//
//                    monsterWeapon = new Weapon("long sword");
//
//                }
//
//
//                Monster monster = new Monster("Demon", human.getLevel(), monsterHealth,monsterWeapon );
//                monsters.add(monster);
//            }
//
//
//
//        }
//
//
//    }
//
//    public String getPlaceName() {
//        return placeName;
//    }
//
//
//
//    public LinkedList<Monster> getMonsters() {
//        return monsters;
//    }
//
//
//}
