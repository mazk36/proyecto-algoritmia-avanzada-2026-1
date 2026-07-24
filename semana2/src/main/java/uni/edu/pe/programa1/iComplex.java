package uni.edu.pe.programa1;

public interface iComplex {
    public iComplex sum(iComplex obj);
    public iComplex times(iComplex obj);
    public boolean isequals(iComplex obj);
    public float module();
    //Aqui hacemos los geter and setter, pero realmente si luego
    //El objeto es protected no haria falta
    public float getReal();
    public void setReal(float real);
    public float getImag();
    public void setImag(float imag);

}
