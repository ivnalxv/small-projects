#include <bits/stdc++.h>
#define file freopen("names.txt", "r", stdin); freopen("names.txt", "w", stdout);
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define F first
#define S second

using namespace std;



signed main() {
    srand(time(0));

    vector<string> sog = {"q", "w", "r", "t", "p", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v",
    "b", "n", "m"};

    vector<string> gla = {"e", "u", "o", "a", "i", "eu", "ue", "ei", "ie", "eo", "oe", "ea", "ae", "ui", "iu", "uo", "ou", "ua", "au", "oa", "ao",
    "oi", "io", "aa", "ee", "uu", "ii", "oo"};

    vector<string> slog = {"qu", "wu", "ru", "tu", "yu", "pu", "su", "du", "fu", "gu", "hu", "ju", "ku", "lu", "zu", "xu", "cu", "vu", "bu", "nu", "mu", "qo", "wo",
    "ro", "to", "yo", "po", "so", "do", "fo", "go", "ho", "jo", "ko", "lo", "zo", "xo", "co", "vo", "bo", "no", "mo", "qa", "wa", "ra", "ta", "ya", "pa", "sa", "da", "fa", "ga",
    "ha", "ja", "ka", "la", "za", "xa", "ca", "va", "ba", "na", "ma", "qe", "we", "re", "te", "ye", "pe", "se", "de", "fe", "ge", "he", "je", "ke", "le", "ze", "xe", "ce", "ve", "be", "ne", "me", "qi", "wi", "ri",
    "ti", "yi", "pi", "si", "di", "fi", "gi", "hi", "ji", "ki", "li", "zi", "xi", "ci", "vi", "bi","ni", "mi",
    "q", "w", "r", "t", "p", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "oi", "io", "aa", "ee", "uu", "ii", "oo",
    "e", "u", "o", "a", "i", "eu", "ue", "ei", "ie", "eo", "oe", "ea", "ae", "ui", "iu", "uo", "ou", "ua", "au", "oa", "ao"};

    int p, l;
    cout << "How many names: ";
    cin >> p;

    cout << "How long can it be: ";
    cin >> l;

    freopen("names.txt", "w", stdout);
    while(p--) {
        string name = "";
        int len = rand()%l + 1, n = slog.size();
        while(len--) {
            name += slog[rand()%n];
        }
        if (name.size() <= 2) {
            //cout << name << endl;
            continue;
        }
        if (name.size() > l) {
            name = name.substr(0, l);
        }

        bool pir = 0;
        for (int i = 1; i < name.size() - 1; i++) {
            bool z1 = 0, z2 = 0, z3 = 0;
            if (name[i - 1] == 'e' || name[i - 1] == 'u' || name[i - 1] == 'i' || name[i - 1] == 'o' || name[i - 1] == 'a') {
                z1 = 1;
            }
            if (name[i] == 'e' || name[i] == 'u' || name[i] == 'i' || name[i] == 'o' || name[i] == 'a') {
                z2 = 1;
            }
            if (name[i + 1] == 'e' || name[i + 1] == 'u' || name[i + 1] == 'i' || name[i + 1] == 'o' || name[i + 1] == 'a') {
                z3 = 1;
            }
            if ( (z1 && z2 && z3) || (!z1 && !z2 && !z3) ) {
                pir = 1;
                break;
            }
        }

        if (pir) continue;
        cout << name << endl;
    }


    return 0;
}
