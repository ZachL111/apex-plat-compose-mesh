package io.portfolio;

public final class DomainReviewTest {
    public static void main(String[] args) {
        var item = new DomainReview.Item(44, 39, 31, 55);
        if (DomainReview.score(item) != 89) throw new AssertionError("domain score mismatch");
        if (!DomainReview.lane(item).equals("hold")) throw new AssertionError("domain lane mismatch");
    }
}
