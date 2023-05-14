# Serwis bankomatów

Zespół serwisujący bankomaty przychodzi do pracy po długim weekendzie.
System zleceń serwisowych zawiera zgłoszenia, które muszą ustawić w kolejce obsługi.
Kolejka związana jest trasą przejazdu grupy konwojowej przez poszczególne regiony a wyznaczona trasa przejazdu pomiędzy regionami została już zatwierdzona.
Zleceń jest bardzo dużo ponieważ oprócz zaplanowanych na dzisiaj standardowych i priorytetowych prac zasilenia bankomatu, pojawiły się inne zgłoszenia które również trzeba obsłużyć.
Jednym z takich zgłoszeń jest sygnał o niskim stanie gotówki bankomatu, który nie był na dzisiaj zaplanowany takie zgłoszenie powinno być zrealizowane zaraz po zakończeniu prac nad zleceniami planowanymi priorytetowymi w danym regionie.
Innym jest sygnał o awarii bankomatu z którym zespół techniczny nie ma komunikacji i nie może przeprowadzić procedury zdalnego ponownego uruchomienia. Takie zgłoszenie powinno zostać zrealizowane w pierwszej kolejności w danym regionie.
Priorytetowe planowane zasilenie bankomatu dotyczy urządzenia gdzie trend zużycia stanu gotówki jest wysoki dlatego ta operacja jest wykonywana przez zleceniami standardowymi.

## Zadanie
Przygotuj system który przygotuje odpowiednią kolejność zleceń do obsługi dla grupy konwojowej, przy założeniu że:
1)	konwój przejeżdża przez regiony biorąc pod uwagę rosnącą kolejność przydzielonych im numerów,
2)	dany bankomat na liście zleceń dla grupy konwojowej może wystąpić tylko raz.

# Rozwiązanie

## Możliwości
"PRIORITY" - Zaplanowane o wysokim priorytecie

"FAILURE_RESTART" - Awaria bankomatu w danym regionie

"SIGNAL_LOW" - Nieplanowany o niskim stanie gotówki

"STANDARD" - Zaplanowane o standardowym priorytecie

## Priorytety po wjechaniu do danego regionu

1. FAILURE_RESTART
2. PRIORITY
3. SIGNAL_LOW
4. STANDARD

## Algorytm

1. Posortuj dane po region ID
2. Posortuj dane w regionach po priorytecie