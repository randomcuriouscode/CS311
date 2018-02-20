package cs311_anagrams;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/***
 * Node object representing a tree node containing an anagram class as data
 * @author rpg711
 *
 */
public class AnagramClassNode implements Comparable<AnagramClassNode>{
	private AnagramClassNodeData data = null;
	private AnagramClassNode leftChild = null;
	private AnagramClassNode rightChild = null;
	
	public void setLeftChild(AnagramClassNode c){
		this.leftChild = c;
	}
	
	public AnagramClassNode getLeftChild(){
		return this.leftChild;
	}
	
	public void setRightChild(AnagramClassNode c){
		this.rightChild = c;
	}
	
	public AnagramClassNode getRightChild(){
		return this.rightChild;
	}
	
	public boolean hasLeftChild() {
		return this.getLeftChild() != null;
	}
	
	public boolean hasRightChild() {
		return this.getRightChild() != null;
	}
	
	/***
	 * This constructor should only be used to create the empty sentinel
	 * @param tag
	 */
	public AnagramClassNode(String tag){
		this.data = new AnagramClassNodeData(tag);
	}
	
	public AnagramClassNode(String tag, String member){
		this.data = new AnagramClassNodeData(tag);
		this.data.addMember(member);
	}
	
	public AnagramClassNodeData getData(){
		return this.data;
	}
	
	public void setData(AnagramClassNodeData data){
		this.data = data;
	}
	
	@Override
	public String toString(){
		return this.getData().toString();
	}

	@Override
	/***
	 * Compares the tag of the data of this instance of AnagramClassNode to the given AnagramClassNode
	 */
	public int compareTo(AnagramClassNode o) {
		return this.getData().compareTo(o.getData());
	}
}
