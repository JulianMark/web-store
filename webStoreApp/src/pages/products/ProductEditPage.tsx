import {
  IonButton,
  IonButtons,
  IonCard,
  IonCol,
  IonContent,
  IonHeader,
  IonIcon,
  IonInput,
  IonItem,
  IonLabel,
  IonMenuButton,
  IonPage,
  IonRow,
  IonTitle,
  IonToolbar,
} from "@ionic/react";
import { add, checkmark } from "ionicons/icons";
import { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router";
import "../Page.css";
import Product from "./Product";
import { saveProduct, searchProductById } from "./ProductsApi";

const ProductEditPage: React.FC = () => {
  const { name, id } = useParams<{ name: string; id: string }>();
  const [product, setProduct] = useState<Product>({});
  const history = useHistory();

  useEffect(() => {
    search();
  }, []);

  const isNew = id === "new";

  const search = () => {
    if (!isNew){
      let result = searchProductById(id);
      setProduct(result);
    }
  }

  const save = () => {
    saveProduct(product);
    history.push("/page/products/");
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
            <IonTitle>
              {isNew ? "Agregar Producto" : "Actualizar Producto"}
            </IonTitle>

            <IonRow>
              <IonCol>
                <IonItem>
                  <IonLabel position="floating">Descripción</IonLabel>
                  <IonInput
                    onIonChange={(e) => (product.name = String(e.detail.value))}
                    value={product.name}
                  ></IonInput>
                </IonItem>
              </IonCol>
              <IonCol>
                <IonItem>
                  <IonLabel position="floating">Precio</IonLabel>
                  <IonInput
                    onIonChange={(e) =>
                      (product.price = String(e.detail.value))
                    }
                    value={product.price}
                  ></IonInput>
                </IonItem>
              </IonCol>
            </IonRow>

            <IonRow>
              <IonCol>
                <IonItem>
                  <IonLabel position="floating">Cantidad</IonLabel>
                  <IonInput
                    onIonChange={(e) =>
                      (product.stock = String(e.detail.value))
                    }
                    value={product.stock}
                  ></IonInput>
                </IonItem>
              </IonCol>
              <IonCol>
                <IonItem>
                  <IonLabel position="floating">Estado</IonLabel>
                  <IonInput
                    onIonChange={(e) =>
                      (product.status = String(e.detail.value))
                    }
                    value={product.status}
                  ></IonInput>
                </IonItem>
              </IonCol>
            </IonRow>

            {!isNew && (
              <IonRow>
                <IonCol>
                  <IonItem>
                    <IonLabel position="floating">Fecha de alta</IonLabel>
                    <IonInput
                      value={product.createAt}
                      disabled={true}
                    ></IonInput>
                  </IonItem>
                </IonCol>
              </IonRow>
            )}

            <IonItem>
              <IonButton
                color="success"
                slot="end"
                size="default"
                onClick={save}
              >
                <IonIcon icon={isNew ? add : checkmark} />
                {isNew ? "Agregar" : "Actualizar"}
              </IonButton>
            </IonItem>
          </IonCard>
        </IonContent>
      </IonContent>
    </IonPage>
  );
};

export default ProductEditPage;
