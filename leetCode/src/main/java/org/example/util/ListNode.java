package org.example.util;



import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
