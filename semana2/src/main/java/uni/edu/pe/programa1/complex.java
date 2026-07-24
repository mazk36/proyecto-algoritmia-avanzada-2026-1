package uni.edu.pe.programa1;

public class complex implements iComplex{
    private float real ;
    private float imag ;


    //Este es mi constructor
    public complex(float real, float imag)
    {
        this.real = real ;
        this.imag = imag ;
    }
    //geter n setter
    @Override
    public float getReal() {
        return real;
    }

    @Override
    public void setReal(float real) {
        this.real = real;
    }

    @Override
    public float getImag() {
        return imag;
    }

    @Override
    public void setImag(float imag) {
        this.imag = imag;
    }

    //Ahora vamos a implementar
    public iComplex sum(iComplex obj)
    {
        iComplex sum = new complex(this.real + obj.getReal(), this.imag + obj.getImag()) ;
        return sum ;
    }
    public iComplex times(iComplex obj) {
        iComplex product = new complex(this.real*obj.getReal()-this.imag*obj.getImag(),this.real*obj.getImag()+this.imag*obj.getReal());
        return product;
    }
    public boolean isequals(iComplex obj)
    {
        return (this.real == obj.getReal() && this.imag == obj.getImag()) ;
    }
    public float module()
    {
        return (float) Math.sqrt((this.real*this.real) + (this.imag*this.imag)) ;
    }


    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }

}
