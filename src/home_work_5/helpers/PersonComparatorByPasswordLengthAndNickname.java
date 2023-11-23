package home_work_5.helpers;

import home_work_5.Person;

public class PersonComparatorByPasswordLengthAndNickname implements IComparator<Person> {
    // NB. Это неправильная реализация. Заметил в последний момент, что сортировка по второму признаку неверна!
    // Там нужно сортировать группу, а не только два объекта в отдельности.
    public int compare(Person o1, Person o2) {
        /**
         * Implements comparison of two {@code Persons} by password length. If lengths are equal
         * makes a further comparison by nicknames according to alphabetic order.
         * @param  o1 the first {@code Person} to compare
         * @param  o2 the second {@code Person} to compare
         * @return the value {@code 0} if {@code o1.password.length == o2.password.length};
         *         a value less than {@code 0} if {@code o1.password.length < o2.password.length}; and
         *         a value greater than {@code 0} if {@code o1.password.length > o2.password.length}
         *         If lengths are equal returns {@code 0} if nicknames are the same; a value less than
         *         {@code 0} if {@code o1.nick} is lexicographically less than {@code o2.nick};
         *         a value greater than {@code 0} if {@code o1.nick} is lexicographically
         *         greater than {@code o2.nick}.
         * */
        PersonComparatorByPasswordLength cmp = new PersonComparatorByPasswordLength();
        int byPasswordLength = cmp.compare(o1, o2);
        if (byPasswordLength == 0)
            return o1.getName().compareTo(o2.getName());
        return byPasswordLength;
    }
}
