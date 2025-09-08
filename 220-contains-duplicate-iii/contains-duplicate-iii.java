class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        var t = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	var val = nums[i];
        	if(i>0) {
        		if(i>indexDiff)
        			t.remove(nums[i-indexDiff-1]);
        		if(t.contains(val))
        			return true;
        		var h = t.higher(val);
        		var l = t.lower(val);
        		if(h!=null)
        			if(Math.abs(h-val)<=valueDiff)
        				return true;
        		if(l!=null)
        			if(Math.abs(l-val)<=valueDiff)
        				return true;
        	}
        	t.add(val);
        }
        return false;
    }
}