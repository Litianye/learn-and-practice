package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-07-31
 */


import lombok.Setter;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-31
 **/

public class ResLinkList {
    public static void main(String[] args) {
//        PrintList(Reverse(CreateList()));
    }

    public static Entity Reverse(Entity head){
        Entity cur = head.Next();
        Entity pre = head;
        pre.setNext(null);
        Entity tmp = null;

        while(cur != null) {
            tmp = cur.Next();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }


        return pre;
    }

    private static Entity CreateList() {
        Entity head = new Entity("0");
        Entity index = head;
        for (int i=1; i<100; i++) {
            Entity entity = new Entity(i+"");
            index.setNext(entity);
            index = entity;
        }
        return head;
    }

    private static void PrintList(Entity entity) {
        System.out.print("[");
        while(entity.hasNext()) {
            System.out.print(entity.getName()+" ");
            entity = entity.Next();
        }
        System.out.print(entity.getName()+"]");
    }
}

class Entity {
    private String name;
    private Entity next = null;

    Entity(String name) {
        this.name = name;
    }

    public Entity Next() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(Entity entity) {
        this.next = entity;
    }

    public String getName() {
        return name;
    }
}