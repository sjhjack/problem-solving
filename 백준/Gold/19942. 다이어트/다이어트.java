import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int minPrice;
    private static Nutrient nutrient;
    private static Ingredient[] arr;
    private static List<Integer> ingredientList = new ArrayList<>();
    private static List<Integer> ansList = new ArrayList<>();

    private static class Nutrient {
        private int mp;
        private int mf;
        private int ms;
        private int mv;

        public Nutrient(int mp, int mf, int ms, int mv) {
            this.mp = mp;
            this.mf = mf;
            this.ms = ms;
            this.mv = mv;
        }

        public boolean isEnough(Nutrient curNutrient) {
            return curNutrient.mp >= mp && curNutrient.mf >= mf && curNutrient.ms >= ms && curNutrient.mv >= mv;
        }

        public void addIngredient(Ingredient ingredient) {
            mp += ingredient.p;
            mf += ingredient.f;
            ms += ingredient.s;
            mv += ingredient.v;
        }

        public void subIngredient(Ingredient ingredient) {
            mp -= ingredient.p;
            mf -= ingredient.f;
            ms -= ingredient.s;
            mv -= ingredient.v;
        }
    }

    private static class Ingredient {
        int p;
        int f;
        int s;
        int v;
        int c;

        public Ingredient(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Ingredient[N];

        st = new StringTokenizer(br.readLine());
        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());

        nutrient = new Nutrient(mp, mf, ms, mv);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Ingredient(p, f, s, v, c);
        }
    }

    private static void solve() {
        minPrice = Integer.MAX_VALUE;

        selectIngredient(0, new Nutrient(0, 0, 0, 0), 0);
    }

    private static void selectIngredient(int idx, Nutrient curNutrient, int price) {
        if(idx >= N || price >= minPrice) {
            return;
        }

        // 식재료 추가
        curNutrient.addIngredient(arr[idx]);
        price += arr[idx].c;
        ingredientList.add(idx + 1);

        if(price < minPrice) {
            if(nutrient.isEnough(curNutrient)) {
                saveAns(price);
            } else {
                selectIngredient(idx + 1, curNutrient, price);
            }
        }

        // 식재료 제외
        curNutrient.subIngredient(arr[idx]);
        price -= arr[idx].c;
        ingredientList.remove(ingredientList.size() - 1);

        selectIngredient(idx + 1, curNutrient, price);
    }

    private static void saveAns(int price) {
        ansList.clear();
        ansList.addAll(ingredientList);

        minPrice = price;
    }

    private static void print() {
        if(minPrice < Integer.MAX_VALUE) {
            StringBuilder ans = new StringBuilder();

            ans.append(minPrice).append("\n");

            for(int idx : ansList) {
                ans.append(idx).append(" ");
            }

            System.out.print(ans);
        } else {
            System.out.print(-1);
        }
    }
}
