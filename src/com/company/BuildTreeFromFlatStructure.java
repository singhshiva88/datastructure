package com.company;

import java.util.*;

public class BuildTreeFromFlatStructure
{
  public static void main(String[] args)
  {
    List<MyObject> list = new ArrayList<>();
    list.add(new MyObject(null, 0));
    list.add(new MyObject(0, 1));
    list.add(new MyObject(0, 2));
    list.add(new MyObject(0, 3));
    list.add(new MyObject(1, 4));
    list.add(new MyObject(1, 5));
    list.add(new MyObject(1, 6));
    list.add(new MyObject(2, 7));
    list.add(new MyObject(7, 8));
    list.add(new MyObject(8, 9));
    list.add(new MyObject(3, 10));
    Map<Integer, TreeNode> treeMap = new HashMap();
    list.forEach(item -> {
      TreeNode currentNode = treeMap.get(item.getId());
      TreeNode parentNode = treeMap.get(item.getParentId());
      if (currentNode == null)
      {
        treeMap.put(item.getId(), new TreeNode(item));
      }
    });
    list.forEach(item -> {
      Integer parentId = item.getParentId();
      if (parentId != null)
      {
        TreeNode parentNode = treeMap.get(parentId);
        parentNode.addTochildren(treeMap.get(item.getId()));
      }
    });
  }
}

class TreeNode
{
  private Integer id;
  private Integer parentId;
  private List<TreeNode> chilren;

  public TreeNode(MyObject myObject)
  {
    this.id = myObject.getId();
    this.parentId = myObject.getParentId();
  }

  public void addTochildren(TreeNode child)
  {
    if (chilren == null)
    {
      chilren = new ArrayList<>();
    }
    chilren.add(child);
  }

  public List<TreeNode> getChilren()
  {
    return chilren;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getParentId()
  {
    return parentId;
  }

  public void setParentId(Integer parentId)
  {
    this.parentId = parentId;
  }
}

class MyObject
{
  private Integer id;
  private Integer parentId;

  public MyObject(Integer parentId, Integer id)
  {
    this.id = id;
    this.parentId = parentId;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getParentId()
  {
    return parentId;
  }

  public void setParentId(Integer parentId)
  {
    this.parentId = parentId;
  }
}
