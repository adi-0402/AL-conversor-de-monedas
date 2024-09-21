public class Convertor {
    private String base;
    private String objetivo;
    private double conversion;
    private double monto;

    public Convertor(Moneda moneda) {
        this.base = moneda.base_code();
        this.objetivo = moneda.target_code();
        this.conversion = moneda.conversion_rate();
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void hacerConversion() {
        double resultado = monto * conversion;
        System.out.printf("La conversión de %.2f %s a %s es: %.2f %s%n"
                , monto, base, objetivo, resultado, objetivo);
    }
}
