Used to practise:

1 algorithm(couldn't bear any indescribable fucking IndentationError more of python)

2 junit(learn and practise from zero)

3 tdd(whatever)


        //分割商品成Items
        //TODO 商品的peiecePrice被修改后的情况怎么办
        if(product.piecePrice<=product.price){

            int pieceCount=product.price/product.piecePrice;

            IntStream.range(0,pieceCount).forEach(i->splitProductToItem(product));

        }
        
        @Entity
public class Item extends BasicGenericModel {
    @Id
    public String id;

    //外键 Product.id
    @OneToOne()
    @JoinColumn(name="id")
    public Product product;





}
