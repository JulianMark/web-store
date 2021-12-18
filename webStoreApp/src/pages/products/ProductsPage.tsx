import {
  IonButton,
  IonButtons,
  IonCard,
  IonCol,
  IonContent,
  IonGrid,
  IonHeader,
  IonIcon,
  IonItem,
  IonMenuButton,
  IonPage,
  IonRow,
  IonTitle,
  IonToolbar,
} from "@ionic/react";
import { add, close, pencil } from "ionicons/icons";
import { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router";
import "../Page.css";
import Product from "./Product";
import { removeProduct, saveProduct, searchProducts } from "./ProductsApi";

const ProductsPage: React.FC = () => {
  const { name } = useParams<{ name: string }>();
  const [products, setProducts] = useState<Product[]>([]);
  const history = useHistory();

  useEffect(() => {
    search();
  }, [history.location.pathname]);

  const search = () => {
    let result = searchProducts();
    setProducts(result);
  };

  const localStoreTest = () => {
    let mockData = {
      id: "1",
      name: "Coca cola",
      price: "299.00",
      stock: "98",
      status: "activo",
      createAt: "11-05-1985",
    };

    saveProduct(mockData);
  };

  const addProduct = () => {
    history.push("/page/products/new");
    search();
  };

  const editProduct = (id: string) => {
    history.push("/page/products/" + id);
  };

  const remove = (id: string) => {
    removeProduct(id);
    search();
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{name}</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">{name}</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonContent>
          <IonCard>
            <IonTitle>Gestión de Productos</IonTitle>

            <IonItem>
              <IonButton
                color="primary"
                slot="end"
                size="default"
                onClick={addProduct}
              >
                <IonIcon icon={add} />
                Agregar Producto
              </IonButton>
            </IonItem>

            <IonGrid className="table">
              <IonRow>
                <IonCol>Descripción</IonCol>
                <IonCol>Precio</IonCol>
                <IonCol>Disponible</IonCol>
                <IonCol>Estado</IonCol>
                <IonCol>Fecha Alta</IonCol>
                <IonCol>Acciones</IonCol>
              </IonRow>

              {products.map((product: Product) => (
                <IonRow>
                  <IonCol>{product.name}</IonCol>
                  <IonCol>{product.price}</IonCol>
                  <IonCol>{product.stock}</IonCol>
                  <IonCol>{product.status}</IonCol>
                  <IonCol>{product.createAt}</IonCol>
                  <IonCol>
                    <IonButton
                      color="primary"
                      fill="clear"
                      onClick={() => editProduct(String(product.id))}
                    >
                      <IonIcon icon={pencil} slot="icon-only" />
                    </IonButton>
                    <IonButton
                      color="danger"
                      fill="clear"
                      onClick={() => remove(String(product.id))}
                    >
                      <IonIcon icon={close} slot="icon-only" />
                    </IonButton>
                  </IonCol>
                </IonRow>
              ))}
            </IonGrid>
            <IonItem>
              <IonButton
                color="primary"
                slot="end"
                size="default"
                onClick={localStoreTest}
              >
                <IonIcon icon={add} />
                Agregar Producto Test
              </IonButton>
            </IonItem>
          </IonCard>
        </IonContent>
      </IonContent>
    </IonPage>
  );
};

export default ProductsPage;
