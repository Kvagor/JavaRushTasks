package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet(){
        map = new HashMap<>();
    }

    public AmigoSet( Collection<? extends E> collection) {
        map = new HashMap<>((int) Math.max(Math.ceil(collection.size()/.75f),16));
        collection.stream()
                .forEach(x->map.put(x,PRESENT));
    }

    @Override
    public boolean add(E e) {
        Object put = map.put(e, PRESENT);
        if (put==null){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet<E> amigo = (AmigoSet<E>) super.clone();
            amigo.map = (HashMap<E, Object>) map.clone();
            return amigo;
        }catch (Exception e){
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream obj){
        try {
            obj.defaultWriteObject();
            obj.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
            obj.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
            obj.writeInt(map.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.keySet().stream().forEach(e-> {
            try {
                obj.writeObject(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException {
            obj.defaultReadObject();
            int i = obj.readInt();
            float loadF = obj.readFloat();
            int size = obj.readInt();
            map = new HashMap<>(i,loadF);
            for (int j = 0; j < size; j++) {
                map.put((E) obj.readObject(),PRESENT);
            }





    }

}
