/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

/**
 *
 * @author leonardoamurca
 * @param <E>
 */
public class Node<E> {

    private E value;
    private Node previous;

    public E getValue() {
        return value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

}
