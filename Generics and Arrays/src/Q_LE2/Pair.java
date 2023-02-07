package Q_LE2;

public class Pair<Y, N> {
    private Y key;
    private N value;

    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(Y key) {
        this.key = key;
    }

    public void setValue(N value) {
        this.value = value;
    }

    public Y getKey() {
        return key;
    }

    public N getValue() {
        return value;
    }

}
