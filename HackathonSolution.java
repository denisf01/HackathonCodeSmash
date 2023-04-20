package Hackahton;

import java.util.*;

class Foo {
	/*
	 * Complete the 'IsBuyerWinner' function below.
	 *
	 * The function is expected to return an Integer. The function accepts following
	 * parameters: 1. List (STRING_ARRAY) - codeList 2. List (STRING_ARRAY) -
	 * shoppingCart
	 */
	public static int isBuyerWinner(List<String> codeList, List<String> shoppingCart) {
		int codeListIndex = 0, fruitGroupIndex = 0, shoppingCartIndex = 0;
		while (codeListIndex < codeList.size() && shoppingCartIndex < shoppingCart.size()) {
			// vrtimo se u petlji dok nismo prosli kroz sve elemente codeListe, tj. nismo zakljucili da smo
			// pobjednici, ili dok nismo prosli kroz sve elemente shoppingCart liste
			if (codeList.get(codeListIndex).split(" ")[fruitGroupIndex].equals(shoppingCart.get(shoppingCartIndex))
					|| codeList.get(codeListIndex).split(" ")[fruitGroupIndex].equals("anything")) {
				// ako nam voce iz fruitGrupe odgovara vocu iz shoppingCart-a, ispunjavamo uslov, te prelazimo na 
				// naredni element iz fruitGrupe
				if (++fruitGroupIndex == codeList.get(codeListIndex).split(" ").length) {
					fruitGroupIndex = 0;
					++codeListIndex;
					// ako smo dosli do kraja fruitGrupe, ta grupa pa ociscena, te prelazimo na narednu fruitGrupu
					// unutar codeListe (ako takva postoji)
				}
			} else {
				fruitGroupIndex = 0;
				// ako nemamo poklapanje elemenata, vracamo se na pocetak trenutne fruitGrupe
			}
			shoppingCartIndex++;
			// u svakoj iteraciji posmatramo narednu vocku iz shoppingCart-a
		}
		if (codeListIndex == codeList.size())
			// ako je petlja napustena iz razloga sto smo dosli do kraja codeListe, imamo pobjednika
			return 1;
		else
			return 0;
	}
}

public class HackathonSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int codeListCount = Integer.parseInt(scanner.nextLine().trim());
		List<String> codeList = new ArrayList<String>();
		for (int i = 0; i < codeListCount; i++) {
			String codeListItem = scanner.nextLine();
			codeList.add(codeListItem);
		}

		int shoppingCartCount = Integer.parseInt(scanner.nextLine().trim());
		List<String> shoppingCart = new ArrayList<String>();
		for (int i = 0; i < shoppingCartCount; i++) {
			String shoppingCartItem = scanner.nextLine();
			shoppingCart.add(shoppingCartItem);
		}

		int foo = Foo.isBuyerWinner(codeList, shoppingCart);
		System.out.println(foo);

		scanner.close();
	}
}
