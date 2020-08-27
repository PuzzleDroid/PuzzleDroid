import App from "next/app";
import "../styles.scss";
import { appWithTranslation } from "../lib/i18n";

const MyApp = ({ Component, pageProps }) => <Component {...pageProps} />;

MyApp.getInitialProps = async (appContext) => ({
  ...(await App.getInitialProps(appContext)),
});

export default appWithTranslation(MyApp);
