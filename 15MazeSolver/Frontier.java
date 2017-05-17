public interface Frontier{
    
    public void add(Location next);

    public Location next();

    public boolean hasNext();

    public int size();

}
